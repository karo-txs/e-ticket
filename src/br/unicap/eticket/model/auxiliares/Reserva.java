package br.unicap.eticket.model.auxiliares;

import br.unicap.eticket.control.auxiliares.ReservaControl;
import br.unicap.eticket.dao.ReservaDAO;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.model.locaisAuxiliares.Sessao;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva implements Serializable, Comparable<Reserva> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    
    @Lob
    @Column(name = "codigo", columnDefinition = "mediumblob")
    private byte[] qrCode;
    
    @ManyToOne
    private Sessao sessao;
    
    @Column
    private String assento;
    
    @Column
    private Double valorIngresso;
    
    @Column
    private boolean avaliacaoDisp;
    
    public Reserva() {
    }
    
    public Reserva(Sessao sessao, String assento) {
        this.sessao = sessao;
        this.assento = assento;
        this.valorIngresso = sessao.getSala().getValorIngresso();
        this.avaliacaoDisp = true;
    }
    
    public Reserva(Sessao sessao, String assento, byte[] codigo) {
        this(sessao, assento);
        this.qrCode = codigo;
    }

    /**
     * Gera um imagem PNG com um código de barras ou com um QRCode
     *
     * @param valor - string que será codificada no barcode ou qrcode
     * @param urlCodigo - nome do arquivo que irá conter a imagem gerada
     * @return
     */
    public boolean gerarCodigo(String valor, String urlCodigo) {
        if ((urlCodigo == null) || (valor == null)) {
            return false;
        }
        if (urlCodigo.length() == 0) {
            return false;
        }
        try {
            Path filePath = FileSystems.getDefault().getPath(urlCodigo);
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(valor, BarcodeFormat.QR_CODE, 150, 150);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", filePath);
            salvarCodigo(urlCodigo);
            return true;
            
        } catch (NumberFormatException e) {
            System.err.println("Erro na conversão para inteiro. Garanta que o 2o argumento seja um número inteiro");
        } catch (WriterException | IOException e) {
            System.err.println("Não foi possível gerar arquivo com o argumento fornecido. Erro: " + e.toString());
        } catch (Exception e) {
            System.err.println("Algo deu errado. " + e.toString());
        }
        
        return false;
    }
    
    private void salvarCodigo(String urlCodigo) {
        File file = new File(urlCodigo);
        byte[] bFile = new byte[(int) file.length()];
        
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setQrCode(bFile);
    }
    
    public void finalizarReserva() throws CadastroInexistenteException {
        ReservaControl rc = new ReservaControl();
        Reserva busca = this.getId() == null ? rc.buscar(this) : this;
        busca.setAvaliacaoDisp(false);
        rc.atualizar(busca);
    }

    //Gets e Sets
    public String getAssento() {
        return this.assento;
    }
    
    public byte[] getQrCode() {
        return qrCode;
    }
    
    public void setQrCode(byte[] qrCode) {
        this.qrCode = qrCode;
    }
    
    public void setAssento(String assento) {
        this.assento = assento;
    }
    
    public Sessao getSessao() {
        return this.sessao;
    }
    
    public void setSessao(Sessao Sessao) {
        this.sessao = Sessao;
    }
    
    public Long getId() {
        return id;
    }
    
    public Double getValorIngresso() {
        return valorIngresso;
    }
    
    public void setValorIngresso(Double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }
    
    public boolean isAvaliacaoDisp() {
        return avaliacaoDisp;
    }
    
    public void setAvaliacaoDisp(boolean avaliacaoDisp) {
        ReservaDAO rd = new ReservaDAO();
        Reserva busca = this.getId() == null ? rd.buscarReserva(this) : this;
        busca.avaliacaoDisp = avaliacaoDisp;
        rd.atualizarAtomico(busca);
    }
    
    @Override
    public String toString() {
        return "Local=" + this.getSessao().getLocal().getNome() + " | Sessão=" + this.getSessao().getNome() + " | Assento=" + assento;
    }
    
    @Override
    public int compareTo(Reserva o) {
        return this.getId().compareTo(o.getId());
    }
    
}

package br.unicap.eticket.testes;

import br.unicap.eticket.control.auxiliares.EntretenimentoControl;
import br.unicap.eticket.excecoes.CadastroInexistenteException;
import br.unicap.eticket.excecoes.DadosInvalidosException;
import br.unicap.eticket.model.locaisAuxiliares.Classificacao;
import br.unicap.eticket.model.locaisAuxiliares.Filme;

public class CadastroFilmes {
    public static void main(String[] args) throws CadastroInexistenteException, DadosInvalidosException{
        
        EntretenimentoControl filmeC = new EntretenimentoControl();
        Filme f1 = new Filme("40 Dias - O Milagre da Vida", "Cary Solomon, Chuck Konzelman", 110,Classificacao.DEZOITO, "Baseado no livro autobiográfico de Abby Johnson, 40 Dias: O Milagre da Vida chega aos cinemas nacionais em 14 de maio e traz relatos reais de uma ex-funcionária da Paternidade Planejada, organização responsável por metade dos abortos realizados nos Estados Unidos. Abby renunciou ao cargo de diretora de uma das clínica em 2009 e, desde então, atua como ativista pró-vida na luta contra o aborto. “Eu queria que as pessoas vissem aquilo que eu vi. Eu queria que elas sentissem o mesmo sentimento de urgência que eu sinto todos os dias”, afirma a escritora e ativista.");
        filmeC.cadastrar(f1, "src\\br\\unicap\\eticket\\imagens\\filmesCapas\\40 Dias - O Milagre da Vida.png");
       
        f1 = new Filme("Amizade Maldita", "Brandon Christensen", 84,Classificacao.DEZOITO, "Kevin (Sean Rogerson) e Beth (Keegan Connor Tracy) notam que seu filho de oito anos, Josh (Jett Klyne), tem passado bastante tempo brincando com um novo amigo imaginário, chamado Z. O que a princípio parece uma relação inofensiva, rapidamente se transforma em algo destrutivo e perigoso. É quando Beth começa a desvendar o seu próprio passado, que ela descobre que Z pode não estar apenas na imaginação do filho.");
        filmeC.cadastrar(f1, "src\\br\\unicap\\eticket\\imagens\\filmesCapas\\Amizade Maldita.png");
        
        f1 = new Filme("Cadê Você, Bernadette", "Richard Linklater", 110,Classificacao.QUATORZE, "Quem nunca sentiu vontade ligar o modo avião e sumir do mapa? Quando a vida de Bernadette (Cate Blanchett) começou a parecer sem rumo, ela resolveu fugir da sua zona de conforto e desaparecer misteriosamente, deixando tudo para trás. Agora Bee (Emma Nelson), sua filha, precisará juntar todas as pistas para descobrir onde foi parar essa mulher que imaginava conhecer tão bem, mas que se transformou em um verdadeiro ponto de interrogação.");
        filmeC.cadastrar(f1, "src\\br\\unicap\\eticket\\imagens\\filmesCapas\\Cadê Você, Bernadette.png");
    
        f1 = new Filme("Hellboy", "Neil Marshall", 121,Classificacao.DEZESSEIS, "Nimue (Milla Jovovich), a Rainha de Sangue, foi uma bruxa tão poderosa que nenhum mortal jamais conseguiu derrotá-la. Durante uma batalha, seu corpo foi dividido em seis partes e espalhado pelos lugares mais distantes da Terra. Séculos depois, um massacre num mosteiro próximo à Londres levanta a suspeita de que alguém pode estar querendo ressuscitá-la e Hellboy (David Harbour) recebe a missão de conter essa terrível ameaça.");
        filmeC.cadastrar(f1, "src\\br\\unicap\\eticket\\imagens\\filmesCapas\\Hellboy.png");
        
        f1 = new Filme("Invasão ao Serviço Secreto", "Ric Roman Waugh", 120,Classificacao.QUATORZE, "Após uma tentativa de assassinato ao presidente dos Estados Unidos (Morgan Freeman), o agente do Serviço Secreto, Mike Banning (Gerard Butler), é injustamente acusado e levado sob custódia. Determinado a provar sua inocência, ele se torna um alvo do FBI à medida em que tenta encontrar o verdadeiro culpado. Ele vai precisar de toda a ajuda possível para proteger sua família e salvar seu país de um ataque sem precedentes.");
        filmeC.cadastrar(f1, "src\\br\\unicap\\eticket\\imagens\\filmesCapas\\Invasão ao Serviço Secreto.png");
        
        f1 = new Filme("Maria e João", "Oz Perkins", 88,Classificacao.QUATORZE, "Desta vez, as migalhas nos guiarão por um caminho muito mais sombrio e perturbador. Durante um período de escassez, Maria (Sophia Lillis) e seu irmão mais novo, João (Sammy Leakey), saem de casa e partem para a floresta em busca de comida e sobrevivência. É quando encontram uma senhora (Alice Krige), cujas intenções podem não ser tão inocentes quanto parecem, que eles descobrem que nem todo conto de fadas tem final feliz.");
        filmeC.cadastrar(f1, "src\\br\\unicap\\eticket\\imagens\\filmesCapas\\Maria e João.png");
        
        f1 = new Filme("O Segredo Ouse Sonhar", "Andy Tennant", 107,Classificacao.LIVRE, "Inspirado no best-seller que vendeu mais de 30 milhões de cópias ao redor mundo, O Segredo: Ouse Sonhar traz a história de Miranda (Katie Holmes), uma viúva que luta para criar os três filhos sozinha. Após uma forte tempestade destruir sua casa, ela contrata Bray (Josh Lucas) para ajudá-la na reconstrução. Durante a obra, ele passa a compartilhar com Miranda sua filosofia de acreditar no poder do universo, na relação causa e efeito, passado e presente.");
        filmeC.cadastrar(f1, "src\\br\\unicap\\eticket\\imagens\\filmesCapas\\O Segredo Ouse Sonhar.png");
        
        f1 = new Filme("Um dia de Chuva em Nova York", "Woody Allen", 94,Classificacao.LIVRE, "Apaixonado por Nova York, Gatsby (Timothée Chalamet) decide passar um fim de semana na cidade ao lado de Ashleigh (Elle Fanning), sua namorada. No entanto, aquilo que era pra ser uma aventura romântica acaba tomando um rumo inesperado. Aspirante a jornalista, Ashleigh conhece o diretor de cinema Roland Pollard (Liev Schreiber), que a convida para a exibição de seu mais recente trabalho. Gatsby, por sua vez, encontra Chan (Selena Gomez), a irmã mais nova de sua ex-namorada, com quem passa o restante da viagem. Um dia de chuva em Nova York será o suficiente para fazer com que Ashleigh redescubra suas verdadeiras paixões e Gatsby aprenda que só se vive uma vez - mas que é o suficiente se for ao lado da pessoa certa.");
        filmeC.cadastrar(f1, "src\\br\\unicap\\eticket\\imagens\\filmesCapas\\Um dia de Chuva em Nova York.png");
    
        f1 = new Filme("Veneza", "Miguel Falabella", 92,Classificacao.LIVRE, "Reencontrar o único homem que amou é o sonho de Gringa (Carmen Maura), dona de um bordel no interior do Brasil. Mesmo cega e muito doente, ela insiste em realizar seu último desejo: ir até Veneza para pedir perdão ao amante que abandonou décadas atrás. Para levá-la à cidade italiana, Tonho (Eduardo Moscovis), Rita (Dira Paes) e as outras moças que trabalham para Gringa idealizam um fantástico plano com a ajuda de uma trupe circense.");
        filmeC.cadastrar(f1, "src\\br\\unicap\\eticket\\imagens\\filmesCapas\\Veneza.png");
        
        f1 = new Filme("Encare a musica", "Dean Parisot", 93,Classificacao.LIVRE, "Três décadas depois, Bill (Alex Winter) e Ted (Keanu Reeves) ainda não conseguiram escrever a melhor música de todos os tempos. Os amigos, então, têm a ideia genial de viajar para o futuro, para quando já tiverem escrito a música, e roubá-la de si mesmos… o que poderia dar errado? Ao lado das suas famílias e da inseparável amiga Morte (William Sadler), eles precisam encontrar a música perdida e salvar o mundo de uma possível catástrofe. Tudo isso, claro, sendo excelentes uns com os outros e deixando a festa rolar!");
        filmeC.cadastrar(f1, "src\\br\\unicap\\eticket\\imagens\\filmesCapas\\encare a musica.png");
    }
}

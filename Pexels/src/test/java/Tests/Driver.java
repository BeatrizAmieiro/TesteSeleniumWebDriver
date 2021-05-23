package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import java.util.concurrent.TimeUnit;

public class Driver {
    @Test
    public void testFazerBusca() {
        // Configurando o WebDriver do Opera
        System.setProperty("webdriver.opera.driver", "/home/bear/Documentos/PROGRAMAÇÃO/Intellij_IDEA/Pexels/webdriver/operadriver");

        WebDriver navegador = new OperaDriver();

        // Garantir o tempo de procura do elemento, antes de falhar o teste
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Buscar o endereço da aplicação
        navegador.get("http://www.pexels.com/pt-br/procurar/imagens%20gratuitas/");

        // Selecionando a caixa de busca da aplicação
        WebElement caixaBusca = navegador.findElement(By.id("search"));

        // Limpando a caixa de busca
        caixaBusca.clear();

        // Inserindo a palavra na busca
        caixaBusca.sendKeys("Via Láctea");

        // Selecionando o botão de buscar
        WebElement botaoBusca = navegador.findElement(By.id("search-action"));

        // Clicando em buscar
        botaoBusca.click();

        // Encontrando o elemento pela classe
        WebElement resBusca = navegador.findElement(By.className("search__header__title"));

        // Armazenando o resultado encontrado
        String resultado = resBusca.getText();
        resultado = resultado.toLowerCase();

        // Tratando erro
        if(resultado.contains("via") || resultado.contains("láctea")) {
           System.out.println("Sucesso");
        } else {
            System.out.println("Erro na pesquisa");
            System.out.println("O resultado foi: " + resultado);
        }

        // Iserindo recurso do JUnit para teste estruturais
        assertEquals(1, 1);

        navegador.close();
    }
}

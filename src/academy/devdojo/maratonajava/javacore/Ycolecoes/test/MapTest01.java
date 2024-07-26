package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// Para criar um Map é da mesma forma que trabalhamos você cria uma interface que é um Map, mas daí se você for nessa
// interface você vai ver que nós temos esse <K, V>, K representa a chave e V representa o valor
// Map sempre trabalha dessa forma chave valor, para cada chave você vai ter um valor associado, então no momento da
// criação você precisa dizer qual o tipo da chave e qual o tipo do valor
public class MapTest01 {
    public static void main(String[] args) {
        // Vamos começar com o HashMap e como você sabe quando tem Hash no nome significa que ele vai ordenar as chaves
        // baseado no Hash, ou seja, não tem uma ordem específica a ordem pode mudar enquanto você vai inserindo
        // elementos e obviamente você vai precisar o equals e hashCode implementado porque uma das primeiras regras que
        // você tem no Map é que não podem ter chaves duplicadas

        // Se você quer manter a ordem precisamos trocar para LinkedHashMap, agora você vai ter a ordem de inserção
        // mantendo ainda o Hash
        Map<String, String> map = new LinkedHashMap<>();

        // Adicionando valores no Map
        map.put("teklado", "teclado");
        map.put("mouze", "mouse");
        map.put("vc", "você");

        // Se você tentar colocar duas chaves iguais, como você pode ver ele sobrescreveu, no Set lembre-se que ele não
        // deixa você inserir ele simplesmente ignora, mas no Map ele poem sobrescrevendo o valor que você tem
        //map.put("vc", "você2");

        // Por isso, nós temos esse método putIfAbsent aonde ele só vai adicionar caso ele não exista
        map.putIfAbsent("vc2", "você");

        // Imprimindo Map
        System.out.println(map);

        // Navengado Map
        // Fazendo um for normal a gente tem duas opções: uma utilizando a navegação via chave ou utilizando a
        // navegação via valores
        // Como você sabe para cada chave tem um valor e se você pegar todas essas chaves você tem um Set porque a chave
        // representa valores únicos dentro do Map, portanto nós temos o keySet que nos retorna um Set com o tipo da
        // nossa chave
        // E você tem o values, o values ele retorna algo mais genérico que é uma coleção do tipo dos nossos valores
        for (String key : map.keySet()) {
            System.out.println(key);
            System.out.println("-");

            // Desse for você pode pegar o valor porque todas as chaves estão associadas a um valor
            System.out.println(key + " : " + map.get(key));
        }
        System.out.println("----------------------------");

        // Existe uma outra opção ao invés de você navegar o for pelas chaves, você pode pegar via valor
        for (String value : map.values()) {
            System.out.println(value);
        }
        System.out.println("-------");

        // Existe uma outra forma que podemos fazer, basicamente o nosso Map ele tem esse entrySet que nada mais é do
        // que um objeto que vai ter a chave e o valor só que a forma de criar o for fica um pouco estranha
        // Dessa forma você tem acesso ao mesmo tempo a chave e valor num mesmo for
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

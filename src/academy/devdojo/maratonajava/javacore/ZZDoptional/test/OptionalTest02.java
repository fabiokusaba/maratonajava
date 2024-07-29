package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repositorio.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {
        // O primeiro requisito é você fazer uma busca por título e se existir esse título eu quero alterar
        Optional<Manga> mangaByTitle = MangaRepository.findByTitle("Boku no Hero");
        mangaByTitle.ifPresent(m -> m.setTitle("Boku no Hero 2"));
        System.out.println(mangaByTitle);

        // O segundo requisito é você procurar por id e se o id não existir você lança uma exceção
        // Ele não vai retornar um Optional, mas sim vai retornar um Manga porque você tem essa opção orElse
        // Quando você tem o orElse ele vai extrair o objeto do wrapper que é o Optional, então caso ele encontre ele
        // vai retornar o Manga se não ele vai lançar uma exceção por isso você não tem mais o Optional aqui
        Manga mangaById = MangaRepository.findById(2).orElseThrow(IllegalArgumentException::new);
        System.out.println(mangaById);

        // O próximo requisito é caso não exista por um título eu quero criar um novo Manga
        Manga newManga = MangaRepository.findByTitle("Drifters").orElseGet(() -> new Manga(3, "Drifters", 20));
        System.out.println(newManga);
    }
}

package academy.devdojo.crud.service;

import java.util.Optional;
import java.util.Scanner;

import academy.devdojo.crud.dominio.Anime;
import academy.devdojo.crud.dominio.Producer;
import academy.devdojo.crud.repository.AnimeRepository;

public class AnimeService {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    public static void menu(int op) {
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            case 4 -> update();
        }
    }

    private static void findByName() {
        System.out.println("Type the name or empty to all");
        String name = SCANNER.nextLine();
        AnimeRepository.findByName(name)
            .forEach(a -> System.out.printf("[%d] - %s %d %s%n", a.getId(), a.getName(), a.getEpisodes(), a.getProducer().getName()));
    }

    private static void delete() {
        System.out.println("Type the id of the anime you want to delete");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? Y/N");
        String choice = SCANNER.nextLine();
        if ("y".equalsIgnoreCase(choice)) {
            AnimeRepository.delete(id);
        }
    }

    private static void save() {
        System.out.println("Type the name of the anime");
        String name = SCANNER.nextLine();
        System.out.println("Type the number of episodes");
        int episodes = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Type the id of the producer");
        int producerId = Integer.parseInt(SCANNER.nextLine());
        Anime anime = Anime.builder()
            .name(name)
            .episodes(episodes)
            .producer(Producer.builder().id(producerId).build())
            .build();
        AnimeRepository.save(anime);
    }

    private static void update() {
        System.out.println("Type the id of the object you want to update");
        Optional<Anime> animeOptional = AnimeRepository.findById(Integer.parseInt(SCANNER.nextLine()));
        if (animeOptional.isEmpty()) {
            System.out.println("Anime not found");
            return;
        }
        Anime animeFromDb = animeOptional.get();
        System.out.println("Anime found " + animeFromDb);
        System.out.println("Type the new name or enter to keep the same");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? animeFromDb.getName() : name;

        System.out.println("Type the new number of episodes");
        int episodes = Integer.parseInt(SCANNER.nextLine());

        Anime animeToUpdate = Anime.builder()
            .id(animeFromDb.getId())
            .name(name)
            .episodes(episodes)
            .producer(animeFromDb.getProducer())
            .build();

        AnimeRepository.update(animeToUpdate);
    }
}

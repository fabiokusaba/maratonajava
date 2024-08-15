package academy.devdojo.crud.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MangaTest {
    private Manga manga1;
    private Manga manga2;

    @BeforeEach
    public void setUp() {
        manga1 = new Manga("Kimetsu no Yaiba", 24);
        manga2 = new Manga("Kimetsu no Yaiba", 24);
    }

    @Test
    void accessors_ReturnData_WhenInitialized() {
        Assertions.assertEquals("Kimetsu no Yaiba", manga1.name());
        Assertions.assertEquals(24, manga1.episodes());
    }

    @Test
    void equals_ReturnTrue_WhenObjectsAreTheSame() {
        Assertions.assertEquals(manga1, manga2);
    }

    @Test
    void hashCode_ReturnTrue_WhenObjectsAreTheSame() {
        Assertions.assertEquals(manga1.hashCode(), manga2.hashCode());
    }

    @Test
    void constructor_ThrowNullPointerException_WhenNameIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> new Manga(null, 24));
    }

    // É importante você testar isso porque por padrão os Records são imutáveis então se você desenvolver um sistema
    // confiando na imutabilidade e alguém faz alguma alteração que tira essa imutabilidade, por exemplo transformando
    // o Record para uma Class, você pode ter problemas futuros
    @Test
    void isRecord_ReturnTrue_WhenCalledFromManga() {
        Assertions.assertTrue(Manga.class.isRecord());
    }
}
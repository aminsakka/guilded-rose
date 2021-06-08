package com.gildedrose;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseShould {

    @Test
    public void should_update_quality_for_one_day() {
        //Given
        GildedRose rose = new GildedRose(ItemProvider.get());

        //When
        rose.updateQuality();

        //Then
        assertThat(rose.items).extracting(item -> item.sellIn)
                .containsExactly(9, 1, 4, 0, -1, 14, 9, 4);

        assertThat(rose.items).extracting(item -> item.quality)
                .containsExactly(19, 1, 6, 80, 80, 21, 50, 50);
    }

    @Test
    public void should_update_quality_for_two_days() {
        //Given
        GildedRose rose = new GildedRose(ItemProvider.get());

        //When
        rose.updateQuality();
        rose.updateQuality();
        //Then
        //Then
        assertThat(rose.items).extracting(item -> item.sellIn)
                .containsExactly(8, 0, 3, 0, -1, 13, 8, 3);

        assertThat(rose.items).extracting(item -> item.quality)
                .containsExactly(18, 2, 5, 80, 80, 22, 50, 50);
    }

    //Teste le golden master de façon industrualisée
    @Test
    public void should_test_too_many_days() {
        //Given
        GildedRose rose = new GildedRose(ItemProvider.get());
        LegacyGildedRose goldenMaster = new LegacyGildedRose(ItemProvider.get());

        //When
        for (int i = 0; i < 100; i++) {
            rose.updateQuality();
            goldenMaster.updateQuality();

            assertThat(rose.items).extracting(item -> item.sellIn)
                    .containsExactly(Arrays.stream(goldenMaster.items).map(item -> item.sellIn).toArray(Integer[]::new)
                    );

            assertThat(rose.items).extracting(item -> item.quality)
                    .containsExactly(Arrays.stream(goldenMaster.items).map(item -> item.quality).toArray(Integer[]::new)
                    );
        }
    }
}

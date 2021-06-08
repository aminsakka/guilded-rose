package com.gildedrose;

public class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(SULFURAS)) {
                continue;
            }

            item.sellIn = item.sellIn - 1 ;

            if (item.name.equals(AGED_BRIE)) {
                updateAgedBrie(item);
            } else  if (item.name.equals(BACKSTAGE_PASSES)) {
                updateBackastagePasses(item);

            }
            else {
                updateNoramlItem(item);
            }
        }
    }

    private void updateNoramlItem(Item item) {
        decreaseQuality(item);
        if (item.sellIn < 0) {
                   decreaseQuality(item);
        }
    }

    private void updateBackastagePasses(Item item) {
        increaseQuality(item);

        if (item.sellIn < 10) increaseQuality(item);

        if (item.sellIn < 5) increaseQuality(item);

        if (item.sellIn < 0)  item.quality = 0;
    }

    private void updateAgedBrie(Item item) {
        increaseQuality(item);
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
                item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
       }
    }
}
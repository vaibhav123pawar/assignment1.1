package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { 
                if (items[i].quality > 0) {
                	//At the end of each day our system lowers both values for every item -> quality
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros") ) { // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
                    	if(items[i].name.equals("Sulfuras, New Product")) {
                    		if(items[i].quality > 10) {
                    			items[i].quality = items[i].quality - 1;
                    		}
                    	} else {
                    		items[i].quality = items[i].quality - 1;
                    	}
                    }
                }
            } else {
            	//increasing quality
            	//Aged Brie
            	//Backstage passes to a TAFKAL80ETC concert
            	//"Aged Brie" actually increases in Quality the older it gets
                if (items[i].quality < 50) { //The Quality of an item is never more than 50
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) { //"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but 	Quality drops to 0 after the concert
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) { //"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but 	Quality drops to 0 after the concert
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            //At the end of each day our system lowers both values for every item -> sellIn
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) { //Once the sell by date has passed, Quality degrades twice as fast
                if (!items[i].name.equals("Aged Brie")) { //"Aged Brie" actually increases in Quality the older it gets
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {//The Quality of an item is never negative
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros") && !items[i].name.equals("Sulfuras, New Product")) { //"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                    	//"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but 	Quality drops to 0 after the concert
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                   /* if (items[i].quality < 50) {
                    	//Item can never have its Quality increase above 50, however "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters
                        items[i].quality = items[i].quality + 1;
                    }*/
                }
            } else {
            	if(items[i].name.equals("Conjured Mana Cake")) {
            		if(items[i].quality > 0) {
            			items[i].quality = items[i].quality - 1;
            		}
            	}
            }
        }
    }
}

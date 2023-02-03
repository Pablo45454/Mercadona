package com.mercadona.shopone;

public class MercadonaShopOne {
    Item[] items;

    public MercadonaShopOne(Item[] items) {
        this.items = items;
    }
    
    public static boolean maxQualityExceeded(Item item){
        if(!item.name.equals("Iodized salt") && item.quality>50)return false;
        else return true;
    }
    
    public static boolean isGeneric(Item item){
        if(!item.name.equals("Ham") && !item.name.equals("Iodized salt") &&!item.name.equals("Frozen cake") && !item.name.equals("Aged blue cheese") )return true;
        else return false;
    }
    
   public static boolean canExpire(Item item){
       if(item.name.equals("Iodized salt"))return true;
       else return false;
   }
   
   public static void decreaseSellIn(Item item){
       item.sellIn -=1; 
   }
   
   public static boolean isExpired(Item item){
       if(!item.name.equals("Iodized Salt") && item.sellIn<0)return true;
       else return false;
   }

    public void updateQuality() {
        
        for (Item item : items){
            if (!canExpire(item) ) {
                decreaseSellIn(item);
            }
            
            if(item.name.equals("Frozen cake") && isExpired(item)){
                item.quality -= 4;
            } else if(item.name.equals("Frozen cake") && !isExpired(item)){
                item.quality -= 2;
            }
            
            if(item.name.equals("Aged blue cheese")){
                if(isExpired(item)){
                    item.quality +=2;
                } else item.quality +=1;
            }
            
            if(item.name.equals("Ham")){
                if(item.sellIn > 10){
                    item.quality+=1;
                } else if (item.sellIn < 10 && item.sellIn > 5){
                    item.quality+=2;
                } else if (item.sellIn < 5 && !isExpired(item))item.quality+=3;
                else if(isExpired(item))item.quality=0;
            } else if(isGeneric(item) ){
                if(item.quality >= 0){
                    item.quality-=1;
                } else if (item.quality < 0){item.quality-=2;}
                
            }
            
            if(item.quality < 0){
                item.quality = 0;
            } else if(!maxQualityExceeded(item)){
                item.quality=50;
            }
            
            
            }
       
    }
}
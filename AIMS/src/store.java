public class store {
    private static int index = 0;
    DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[1000];

    public void addDigitalVideoDisc(DigitalVideoDisc dvd){
        itemsInStore[index] = dvd;
        index++;
    } 
   
    public void removeDigitalVideoDisc(DigitalVideoDisc dvd){
        int i;
        for(i = 0; i < index; i++)
        {
            
            if(itemsInStore[i].isExist(dvd.getTitle(), dvd.getCategory(), dvd.getDirector(), dvd.getLength(), dvd.getCost()))
            {
                if(itemsInStore[i].stateofdel == true)
                {
                    System.out.println("Error. Disc " + dvd.getTitle() + " has already been deleted.");
                    break;
                }
                itemsInStore[i].stateofdel = true;
                System.out.println("Disc " + dvd.getTitle() + " has been successfully deleted.");
                break;
            }
        }
        if(i == index)
        {
            System.out.println("Error. No disc found.");
        }
    }

    public void displayStore()
    {
        System.out.println("Store:");
        for(int i = 0; i < index; i++)
        {
            if(!itemsInStore[i].stateofdel)
            {
                System.out.println(itemsInStore[i].toString());
            }
        }
    }
}

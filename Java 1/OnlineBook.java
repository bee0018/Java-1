/**
*Practice inheritance our classes.
*Activity 09
*@ Bryce Ellis- COMP-1210-001
*@ 3-30-2020
*/

public class OnlineBook extends OnlineTextItem {

   protected String author;
   
   /**
   *@param nameIn for item.
   *@param priceIn that sets prices
   */
   
   public OnlineBook(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      author = "Author Not Listed";
   }
   
   /** @return name along with other details for the book.**/
   public String toString() {
      return name + " - " + author + ": $" + price;
   }
   
   /** 
   *Sets the author name for the book.
   *@param authorIn for denoting the author
   **/
   public void setAuthor(String authorIn) {
      author = authorIn;
   }
}
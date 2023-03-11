/**
*Practice inheritance our classes.
*Activity 09
*@ Bryce Ellis- COMP-1210-001
*@ 3-30-2020
*/

public class OnlineArticle extends OnlineTextItem {

   private int wordCount;
   
   /**
   *@param nameIn for name of item
   *@param priceIn for price of item
   */
   
   public OnlineArticle(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      wordCount = 0;
   }
   
   /**
   *Sets the number of words that is taken up by online text item.
   *@param wordCountIn used for denoting number of words
   **/
   public void setWordCount(int wordCountIn) {
      wordCount = wordCountIn;
   }


}
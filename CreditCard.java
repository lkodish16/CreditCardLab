public class CreditCard
{
  public String verify(String num)
  {
    String cardNum = num;  // String cardNum holds the full credit card number
    int[] splitNum = new int[cardNum.length()-1];  // the Array splitNum has the a size of how many characters are in cardNum. 
    int[] odd;
    int[] even;
    int oddSum = 0;
    int evenSum = 0;
    int totalSum;
    
    if (cardNum.length() % 2 == 0)  // whether the number has an even or odd number of characters affects the length of the arrays.
    {
      odd = new int[cardNum.length()/2];
      even = new int[cardNum.length()/2];
    }
    else 
    {
      odd = new int[cardNum.length()/2+1];
      even = new int[cardNum.length()/2];
    }
    
    for (int i = 0; i < splitNum.length; i++)  
    {
      splitNum[i] = Integer.parseInt(cardNum.substring(i,i+1));  // each element of splitNum holds a character(number) of the cardNum String.
    }
    
    int i = 0;
    int j = splitNum.length-1;
    if ((cardNum.length()/2) % 2 == 0)
    {
      while (i <= splitNum.length/2 && j >= 0)
      {
        if (j % 2 ==  0)  // if the number is in an even place of the array, add it to the even array.
        {
          even[i] = splitNum[j];
          if (even[i] >= 10)
          {
            even[i] = 1 + (even[i] % 10);
          }
          evenSum += even[i];  // start adding up the sum of the elements of even.
        }
        else  // if the number is in an odd place of the array, add it to the odd array.
        {
          odd[i] = splitNum[j];
          oddSum += odd[i];  // start add up the sum of the elements of odd.
        }
        i++;
        j--;
      }
    }
    else
    {
      while (i <= splitNum.length/2-1 && j >= 0)
      {
        if (j % 2 ==  0)  // if the number is in an even place of the array, add it to the even array.
        {
          even[i] = splitNum[j];
          if (even[i] >= 10)
          {
            even[i] = 1 + (even[i] % 10);
          }
          evenSum += even[i];  // start adding up the sum of the elements of even.
        }
        else  // if the number is in an odd place of the array, add it to the odd array.
        {
          odd[i] = splitNum[j];
          oddSum += odd[i];  // start add up the sum of the elements of odd.
        }
        i++;
        j--;
      }
    }
    
    totalSum = oddSum + evenSum;  // add the sums of the arrays together.
    if (totalSum % 10 == 0)  // the creditcard number is valid if the totalSum is evenly divisible by 10.
    {
      return "Your creditcard number is valid!";
    }
    else 
    {
      return "I'm sorry, but your creditcard number is not valid.";
    }
  }
  
  public int findType(String num)
  {
    String cardNum = num;  // String cardNum holds the full credit card number
    int[] splitNum = new int[cardNum.length()-1];  // the Array splitNum has the a size of how many characters are in cardNum.
    for (int i = 0; i < splitNum.length; i++)  
    {
      splitNum[i] = Integer.parseInt(cardNum.substring(i,i+1));  // each element of splitNum holds a character(number) of the cardNum String.
    }
    if (cardNum.length() < 12)  // checks for minimum length.
    {
      return 0;
    }
    else if ((splitNum[0] == 5)  // checks for MC
               && splitNum[1] == 1
               || splitNum[1] == 2
               || splitNum[1] == 3
               || splitNum[1] == 4
               || splitNum[1] == 5)
    {
      return 1;
    }
    else if (splitNum[0] == 4)  // checks for Visa.
    {
      return 2;
    }
    else if ((splitNum[0] == 3)
               && splitNum[1] == 4
               || splitNum[1] == 7)
    {
      return 3;
    }       
    else if (cardNum.substring(0,4).equals("6011"))  // checks for Discover
    {
      return 4;
    }
    else if (cardNum.substring(0,2).equals("36")  // check for Carte Blanche / Diner's Club
               || cardNum.substring(0,2).equals("38")
               || (cardNum.substring(0,2).equals("30")
                     && splitNum[2] == 1
                     || splitNum[2] == 2
                     || splitNum[2] == 3
                     || splitNum[2] == 4
                     || splitNum[2] == 5))
    {
      return 5;
    }
    else 
    {
      return 0;
    }
  }
}

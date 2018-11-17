# Checkout-Kata
Checkout-Kata

It uses strategy design pattern. Price Strategy is provided at the Checkout initialisation.

 
Test example :-
https://github.com/umer-maqsood/checkout-kata/blob/master/src/test/java/com/umer/checkout/CheckoutTest.java<br />

Example usage:

//set price rules<br />
ItemPriceRule itemPriceRule = new ItemPriceRule();<br />
itemPriceRule.addItemPriceRule("A", new Price(50, 3, 130));<br />
 
//initialise the strategy<br />
PriceStrategy priceStrategy = new SpecialPriceStrategy(itemPriceRule);<br />

//initialise the checkpoint<br />
checkPoint = new Checkout(priceStrategy);<br />

//scan the item<br />
checkPoint.scanItem("A");<br />
checkPoint.getTotalPrice();<br />
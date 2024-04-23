Feature: Add product in cart

	@monitor
	Scenario: Add_Monitor_to_a_cart
	
	Given user validate amazon homepage is loaded
	Then user click on signIn button
	Then user enters username as "username@gmail.com"
	Then user enters password as "Password@123"
	Then user click on login and confirms Login
	Then user searches for product "monitor"
	And user add the product number 1 to cart
	Then user goes to cart from top menu
	Then user validates price on product page and cart price is same
	Then user Validates product total price and cart subtotal is same
	And user removes product from the cart
	
	@laptop
	Scenario: Add_Laptop_to_a_cart
	
	Given user validate amazon homepage is loaded
	Then user click on signIn button
	Then user enters username as "username@gmail.com"
	Then user enters password as "Password@123"
	Then user click on login and confirms Login
	Then user searches for product "laptop"
	And user add the product number 2 to cart
	Then user goes to cart from top menu
	Then user validates price on product page and cart price is same
	And user removes product from the cart
	
	@keyboardheadphone
	Scenario: Add_keyboard_and_headphone_to_cart
	
	Given user validate amazon homepage is loaded
	Then user click on signIn button
	Then user enters username as "username@gmail.com"
	Then user enters password as "Password@123" 
	Then user click on login and confirms Login
	Then user searches for product "headphones"
	And user add the product number 1 to cart
	Then user goes to cart from top menu
	Then user validates price on product page and cart price is same
	Then user searches for product "keyboard"
	And user add the product number 1 to cart
	Then user goes to cart from top menu
	Then user validates price on product page and cart price is same
	#Then user Validates product total price and cart subtotal is same
	
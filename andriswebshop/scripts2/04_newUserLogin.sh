curl --verbose --write-out "\n" --request POST --data @newUser.json --header "Content-Type: application/json" --cookie-jar cart-cookies.txt --cookie cart-cookies.txt http://localhost:8080/andriswebshop-web/shop/users/login
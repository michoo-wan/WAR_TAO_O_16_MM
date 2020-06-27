Feature: User searches for sweater and buys some
  Scenario Outline: Logged user uses search feature, pics an item and proceeds full purchase path, confirmation screenshot is taken
  Given User is logged in to shop account with "<emailAddress>" and "<password>"
    When User searches shop for a "<thing>"
    And Product catalogue page for "<item>" is opened
    And User chooses "<itemSize>" and "<itemAmount>"
    And User adds item to shopping cart and proceeds to checkout
    And User chooses delivery address and <pickup> method and <payment> method and confirms purchase
    Then Confirmation page is displays "<message>"
    And Screenshot is taken with order ID number
    And User closes window

    Examples:
    | emailAddress           | password    | item                        | itemSize | itemAmount | thing | message |
    | vilohob522@tmail15.com | qwerty12345 | Hummingbird Printed Sweater | M        | 2          | Hummingbird | CONFIRMED |
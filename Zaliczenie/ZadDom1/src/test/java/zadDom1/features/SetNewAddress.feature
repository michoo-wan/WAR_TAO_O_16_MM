Feature: User puts delivery address for new account

  Scenario Outline: New order delivery address is given in account settings page
    Given User is logged in to shop account with "<emailAddress>" and "<password>"
    When User opens delivery address form
    And User enters "<address>" and "<firstname>" and "<lastname>" and "<city>" and "<postcode>"
    Then User gets "Address successfully added!" message
    And User address data "<firstname>" and "<lastname>" and "<address>" and "<city>" and "<postcode>" is correct
    And User closes window
    Examples:
    | address | lastname | firstname | city | postcode | emailAddress | password    |
    | Makowa  | Maliniak  | Marek    | Wolka| 00-333   | vilohob522@tmail15.com | qwerty12345 |
    | Polna   | Marciniak | Arek     | Brzezie| 99-888 | vilohob522@tmail15.com | qwerty12345 |
    | Pszeniczna| Piwko   | Darek    | Marki  | 78-234 | vilohob522@tmail15.com | qwerty12345 |



Feature: Allow User to place order on luma site

  Scenario: To check that user is able to place order on luma site
    When User clicks on women section on home page
    When User clicks on tops section under women section
    When User selects size and color on the product
    When User clicks on add to card button on the product
    When User clicks on cart option on home page
    When User clicks on proceed to checkout button
    When User enters all the valid details on shipping address
      | emailAddress      | firstName      | lastName      | company      | streetAddress | city      | postalCode    | phoneNumber      |
      | validEmailAddress | validFirstName | validLastName | validCompany | validAddress  | validCity | validPostCode | validPhoneNumber |
    When User selects state on shipping address
    When User selects country on shipping address
    When User selects shipping method on shipping address
    When User clicks on next button shipping address
    When User clicks on place order button on payment page
    Then User should be able to place order successfully



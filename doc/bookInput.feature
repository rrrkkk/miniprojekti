Feature: user can save a valid book-reference to the system
	Scenario: a valid book reference is saved to the system
		Given user visits the input form for references
		When user inputs a book-reference with id "BA04", author "Beck, Kent and Anders, Cynthia", title "Extreme Programming explained", publisher "Addison-Wesley Professional" and year "2004"
		Then new reference is added to the system

	Scenario: a book reference is not saved in the system if the id is empty
		Given user visits the input form for references
		When user inputs a book-reference with id "", author "Beck, Kent and Anders, Cynthia", title "Extreme Programming explained", publisher "Addison-Wesley Professional" and year "2004"
		Then reference is not added to the system and the form shows error message

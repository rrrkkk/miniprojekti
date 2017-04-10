Feature: user can save a valid book reference to the system
	Scenario: a valid book reference is saved to the system
		Given user visits the input form for references and chooses "book" for type
		When user inputs id "BA04", author "Beck, Kent and Anders, Cynthia", title "Extreme Programming explained", publisher "Addison-Wesley Professional" and year "2004"
		Then new reference is added to the system

	Scenario: a book reference is not saved in the system if the id is empty
		Given user visits the input form for references and chooses "book" for type
		When user inputs id "", author "Beck, Kent and Anders, Cynthia", title "Extreme Programming explained", publisher "Addison-Wesley Professional" and year "2004"
		Then reference is not saved and error message is shown

	Scenario: a book reference is not saved if the author is empty
		Given user visits the input form for references and chooses "book" for type
		When user inputs id "BA04", author "", title "Extreme Programming explained", publisher "Addison-Wesley Professional" and year "2004"
		Then reference is not saved and error message is shown

	Scenario: a book reference is not saved if the title is empty
		Given user visits the input form for references and chooses "book" for type
		When user inputs id "BA04", author "Beck, Kent and Anders, Cynthia", title "Programming explained", publisher "Addison-Wesley Professional" and year "2004"
		Then reference is not saved and error message is shown
		
	Scenario: a book reference is not saved in the system if the publisher is empty
		Given user visits the input form for references and chooses "book" for type
		When user inputs id "BA04", author "Beck, Kent and Anders, Cynthia", title "Extreme Programming explained", publisher "" and year "2004"
		Then reference is not saved and error message is shown

	Scenario: a book reference is not saved in the system if the year is empty
		Given user visits the input form for references and chooses "book" for type
		When user inputs id "BA04", author "Beck, Kent and Anders, Cynthia", title "Extreme Programming explained", publisher "Addison-Wesley Professional" and year ""
		Then reference is not saved and error message is shown


Feature: user can save a valid inproceedings reference to the system

	Scenario: a valid inproceedings reference is saved to the system
		Given user visits input form for references and chooses "inproceedings" for type
		When user inputs id "R02", author "Roumani, Hamzeh", title "Desing guidelines for the lab component of objects-first CS1", booktitle "SIGCSE '02: Proceedings of the 33rd SIGCSE technical symposium on Computer science education" and year "2002"
		Then new reference is added to the system

	Scenario: an inproceedings reference is not saved if the id is empty
		Given user visits input form for references and chooses "inproceedings" for type
		When user inputs id "", author "Roumani, Hamzeh", title "Desing guidelines for the lab component of objects-first CS1", booktitle "SIGCSE '02: Proceedings of the 33rd SIGCSE technical symposium on Computer science education" and year "2002"
		Then reference is not saved and error message is shown

	Scenario: an inproceedings reference is not saved if the author is empty
		Given user visits input form for references and chooses "inproceedings" for type
		When user inputs id "R02", author "", title "Desing guidelines for the lab component of objects-first CS1", booktitle "SIGCSE '02: Proceedings of the 33rd SIGCSE technical symposium on Computer science education" and year "2002"
		Then reference is not saved and error message is shown

	Scenario: an inproceedings reference is not saved if the title is empty
		Given user visits input form for references and chooses "inproceedings" for type
		When user inputs id "R02", author "Roumani, Hamzeh", title "", booktitle "SIGCSE '02: Proceedings of the 33rd SIGCSE technical symposium on Computer science education" and year "2002"
		Then reference is not saved and error message is shown

	Scenario: an inproceedings reference is not saved if the booktitle is empty
		Given user visits input form for references and chooses "inproceedings" for type
		When user inputs id "R02", author "Roumani, Hamzeh", title "Desing guidelines for the lab component of objects-first CS1", booktitle "" and year "2002"
		Then reference is not saved and error message is shown

	Scenario: an inproceedings reference is not saved if the year is empty
		Given user visits input form for references and chooses "inproceedings" for type
		When user inputs id "R02", author "Roumani, Hamzeh", title "Desing guidelines for the lab component of objects-first CS1", booktitle "SIGCSE '02: Proceedings of the 33rd SIGCSE technical symposium on Computer science education" and year ""
		Then reference is not saved and error message is shown


Feature: user can save a valid article reference to the system
	Scenario: a valid article reference is saved to the system
		Given user visits the input form for references and chooses "article" for type
		When user inputs id "RRR03", author "Anthony Robins and Janet Rountree and Nathan Rountree", title "Learning and teaching programming: A review and discussion", journal "Computer Science Education" and year "2003"
		Then new reference is added to the system

	Scenario: an article reference is not saved if the id is empty
		Given user visits input form for references and chooses "article" for type
		When inputs id "", author "Anthony Robins and Janet Rountree and Nathan Rountree", title "Learning and teaching programming: A review and discussion", journal "Computer Science Education" and year "2003"
		Then reference is not saved and error message is shown

	Scenario: an article reference is not saved if the author is empty
		Given user visits input form for references and chooses "article" for type
		When inputs id "RRR03", author "", title "Learning and teaching programming: A review and discussion", journal "Computer Science Education" and year "2003"
		Then reference is not saved and error message is shown

	Scenario: an article reference is not saved if the title is empty
		Given user visits input form for references and chooses "article" for type
		When inputs id "RRR03", author "Anthony Robins and Janet Rountree and Nathan Rountree", title "", journal "Computer Science Education" and year "2003"
		Then reference is not saved and error message is shown

	Scenario: an article reference is not saved if the journal is empty
		Given user visits input form for references and chooses "article" for type
		When inputs id "RRR03", author "Anthony Robins and Janet Rountree and Nathan Rountree", title "Learning and teaching programming: A review and discussion", journal "" and year "2003"
		Then reference is not saved and error message is shown

	Scenario: an article reference is not saved if the year is empty
		Given user visits input form for references and chooses "article" for type
		When inputs id "RRR03", author "Anthony Robins and Janet Rountree and Nathan Rountree", title "Learning and teaching programming: A review and discussion", journal "Computer Science Education" and year ""
		Then reference is not saved and error message is shown


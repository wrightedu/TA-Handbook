#set page(margin: 0.5in)
#set text(size: 16pt)
#set text(font: "Aptos")

#underline([#text(size: 30pt, weight: "bold")[Helproom Rules:]])
#linebreak()
#linebreak()

#text(weight: "bold")[BE NICE]
#linebreak()

// doing explicit numbers bc a "+" will auto reset after a break
1.  Employees should be kind and respectful of all students and coworkers.
2.  Inflammatory topics (politics, religion, ethics, etc.) are not to be discussed during working hours.
3.  Multiple classes will hold office hours in the helproom, please be respectful of their space.

#linebreak()
#text(weight: "bold")[RESPECT THE ROOM]
#linebreak()

4. During working hours, the helproom is not to be used as a gathering or hang-out space for anyone who is not an employee or student seeking help.
5. Do not abuse access. If you are regularly using the helproom for your own personal gain to an extent that impacts students, you will be asked to leave.
6. Keep the helproom clean: trash must be emptied into the hallway bins; if you make a mess, clean it up; lights off, doors closed when you leave.

#linebreak()
#text(weight: "bold")[HELP THE STUDENTS]
#linebreak()

7. If a student enters the helproom, it is the on-duty TA’s responsibility to approach and assist them.
8. Individual student help should not exceed 15 minutes of continuous help at a time. (Students should spend some time working on their own before getting more help.)

#linebreak()

// underline and blue-ify links
#show link: it => underline(text(fill: blue)[#it])

If you have any questions or concerns, please contact:
#linebreak()


#grid(
    columns: (120pt, auto, auto),
    [- Clarissa Milligan:], 
    [
        Russ 341
        #linebreak()
        #link("mailto:clarissa.milligan@wright.edu")
    ],
    []
)
#linebreak()

// automatic mail to hehe
#grid(
    columns: (120pt, auto, auto),
    [- Reese Hatfield:], 
    [
        Russ 329
        #linebreak()
        #link("mailto:reese.hatfield@wright.edu")
    ],
    []
)
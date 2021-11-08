;get character output 
                 LDBA 0xFC15, d
                 STBA 0x0208, d



;LF
                 LDWA 0x000A, i
                 STBA 0xFC16, d

;print dashes
                 .ASCII "----------------------------\x00 \n"

;is the character a number? if not, branch to next condition. if char < 30 and > 39, branch away to BR isLetter

;print out that character
                 LDBA 0x0208,d
                 STBA 0xFC16, d

;if so, is it even or odd? Branch to even case print if even, etc

;even print

;odd print

isLetter:        BRGT isMisc, i 
;is the character a letter?
;print out that character
                 LDBA 0x0208, d
                 STBA 0xFC16, d

;if so, is the letter capital or lowercase?
                 
;is the letter a vowel?

;if the char is not any of the above,
;print out that character and ?
isMisc:          LDBA 0x0208, d
                 STBA 0xFC16, d

       


;print what type of character the character is
                 .ASCII "The letter is a "

                 STOP
                 .END
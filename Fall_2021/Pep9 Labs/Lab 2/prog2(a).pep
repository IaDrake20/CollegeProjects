;get character output 
                 LDBA 0xFC15, d
                 STBA 0x0208, d
                 BR 1 


;LF
                 LDWA 0x000A, i
                 STBA 0xFC16, d

;print dashes
dashes:          .ASCII "----------------------------\x00 \n"
                 STRO dashes, i
;write character to mem

;get character's hex value and load it to A

;is the character a number? if not, branch to next condition. if char < 30 and > 39, branch away to BR isLetter
                 CPBA ;ERROR: Operand specifier expected after mnemonic.
                 BRGT 0x0208, i 
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
     
                 .ASCII "e" ; 

                 STOP
                 .END
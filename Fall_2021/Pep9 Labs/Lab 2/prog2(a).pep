                 BR main, i

;get character output 
main:            LDBA 0xFC15, d
                 STBA 0x0208, d


;LF
                 LDWA 0x000A, i
                 LDBA 0x0208, d


;print dashes
                 STRO dashes, d
                 .BLOCK 2
dashes:          .ASCII "----------------------------\x00 \n"

;quit if Q or q
                 CPBA    'q',i
                 BREQ    QUIT,i
                 CPBA    'Q',i
                 BREQ    QUIT,i
                
;write character to mem
origChar:        STBA 0xFC16, d
                 
;is the character a number? if not, branch to next condition. if char < 30 and > 39, branch away to BR isLetter
                 CPBA 30, i
                 BRLT isLetter, i ;if less than 30, go to letter check
                 CPBA 39, i
                 BRGT isLetter, i

resAnd:          ANDA "1", i 
                 CPBA resAnd, i 
                 BRGT odd, i

even:            LDBA 'E', i ;print E for even
                 STBA 0xFC16, d
                 BR NOTODD, i

odd:             LDBA 'O', i ;print O for odd
                 STBA 0xFC16, d

NOTODD:          LDBA origChar, d
;print out that character
                 LDBA 0x0208,d
                 STBA 0xFC16, d


isLetter:        BRGT isMisc, i 
;is the character a letter?
;print out that character
                 LDBA 0x0208, d
                 STBA 0xFC16, d

;if so, is the letter capital or lowercase?
;check by seeing if its in range or not with BRGE, BRLE
;is the letter a vowel?
;determine by copy pasting checks for a,e,i,o,u

;if the char is not any of the above,
;print out that character and ?
isMisc:          LDBA origChar, d ;load orig char to print
                 STBA 0xFC16, d
                 

       


;print what type of character the character is
     
;final:      .ASCII  ; 

QUIT:            STOP
                 .END
; PUSH 5, 9 , 12 
BR main, i

num1:    .EQUATE 0; SP + {0}
num2:    .EQUATE 2; SP + {2}
num3:    .EQUATE 4; SP + {4}

main:    LDWA 5, i
         ADDSP -2, i
         STWA 0, s

         LDWA 9, i
         ADDSP -2, i
         STWA 0, s

         LDWA 12, i
         ADDSP -2, i
         STWA 0, s

;2nd way         
         ADDSP -6, i
         LDWA 5,i
         STWA num1, s ;top

         LDWA 9,i
         STWA num2, s;2nd spot

         LDWA 12,i 
         STWA num3, s;3rd spot

         ADDSP 6,i
STOP
.END
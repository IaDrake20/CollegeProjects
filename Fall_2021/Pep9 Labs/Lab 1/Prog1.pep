BR 0x0009,i
.BLOCK 6

LDWA 0x0000, i ;clear 
STWA 0x0003, d
STWA 0x0005, d
STWA 0x0007, d

LDWA 0xFFFF, i
STWA 0x0003, d
DECO 0x0003, d


LDWA 0x000A,i
STBA 0xFC16, d

;get input then save it at address 0x403
LDBA 0xFC15, d
STBA 0x0006, d

;display orig char 
STBA 0xFC16, d

;subtract and store uppercase at 0x405
SUBA 0x20, i
STBA 0x0008, d

;LF
LDWA 0x000A,i
STBA 0xFC16, d

;display uppercase char
LDBA 0x0008, d
STBA 0xFC16, d

;LF
LDBA 0x000A, i
STBA 0xFC16, d

;decimal ASCII val of char
DECO 0x0005, d

;LF
LDBA 0x000A, i
STBA 0xFC16, d

;decimal ASCII val of uppercase char
DECO 0x0007, d

;LF
LDBA 0x000A, i
STBA 0xFC16, d

;hex output of orig char
HEXO 0x0005, d

;LF
LDBA 0x000A, i
STBA 0xFC16, d

STOP
.END

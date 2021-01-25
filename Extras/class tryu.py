class emailacc(object):
    def __init__(self,name):
        self.name = name
        self.email = name+"@email.com"
        self.newemails = 0
        self.emaillist = []
    def checkemail(self):
        return print(self.newemails)
    def displayemail(self):
        columnofemails = ""
        emailnum = 1
        for e in self.emaillist:
            columnofemails += str(emailnum)+". "+str(e) + "\n"
            emailnum += 1
        return columnofemails.strip("[]()''")
    def sendmail(self,to,content):
        self.to = to
        to.newemails += 1
        to.emaillist.append(content+" |||| Sent from "+self.name)
    def userinbox(self):
        return print("_________________________\n\n",self.name+" Inbox | New Emails: "+str(self.newemails),"\n","\n"+self.displayemail())
my = emailacc("Alberto")
andrei = emailacc("Andrei")
my.sendmail(andrei,"hola tio com estas")
andrei.userinbox()
my.userinbox()

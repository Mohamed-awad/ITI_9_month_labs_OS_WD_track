var ID = function () {
    return '_' + Math.random().toString(36).substr(2, 9);
};

var  new_name = function(name) {
    var res = name.split(" ");
    return res[0][0].toUpperCase()+'.'+ res[1];
}

var  new_email = function(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(re.test(String(email).toLowerCase()) === true )
    {
        return email;
    }
    else
    {
        return 'awadmohamed233@gmail.com';
    }
}

var  new_phone = function(phone) {
    var re = /^\d{11}$/;
    if(re.test(String(phone).toLowerCase()) === true)
    {
      return phone;
    }
    else
    {
        return '01111451253'
    }
}

var Contact = function (name, email, phone) {
    this.id = ID();
    this.name = new_name(name);
    this.email = new_email(email);
    this.phone = new_phone(phone);
};

var ContactList = function (name) {
    this.name = name;
    this.contacts = [];
};

ContactList.prototype.addContact = function(contact)
{
    this.contacts.push(contact);
}

ContactList.prototype.removeContact = function(id)
{
    for(var i = 0 ; i < this.contacts.length; i++)
    {
        if(this.contacts[i].id == id)
        {
            delete this.contacts[i];
        }
    }
}

ContactList.prototype.editContact = function(id, new_contact)
{
    for(var i = 0 ; i < this.contacts.length; i++)
    {
        if(this.contacts[i].id == new_contact.id)
        {
            this.contacts[i].name = new_contact.name;
            this.contacts[i].email = new_contact.email;
            this.contacts[i].phone = new_contact.phone;
        }
    }
}

ContactList.prototype.getContact = function(id)
{
    for(var i = 0 ; i < this.contacts.length; i++)
    {
        if(this.contacts[i].id == id)
        {
            return this.contacts[i];
        }
    } 
}

ContactList.prototype.getAllContacts = function()
{
   return this.contacts; 
}


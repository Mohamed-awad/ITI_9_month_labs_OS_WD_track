import re


def hasNumbers(user_name):
  return any(char.isdigit() for char in user_name)


def isValidEmail(email):
  if len(email) > 7:
    if re.match('^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$', email):
      return True
    return False


while True:
  name = input("enter your name : ")
  if(name and not hasNumbers(name)):
    break

while True:
  email = input("enter your email : ")
  if(isValidEmail(email)):
    break


print("your name is : " + name)

print("your email is : " + email)



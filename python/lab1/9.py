
my_str = input("please enter your string : ")

mx = -1
longest_str = ""
current_str = ""
cnt = 1

""" 
    A a B b C c D d E e F f G g H h I i J j K k L l 
    M m N n O o P p Q q R r S s T t U u V v W w X x Y y Z z

 """


for ind in range(len(my_str)-1):
  if my_str[ind] <= my_str[ind+1]:
    cnt += 1
    current_str += my_str[ind]
  else :
    if cnt > mx:
      mx = cnt
      longest_str = current_str + my_str[ind]
      cnt = 1
    # print(current_str + my_str[ind])
    current_str = ""

if cnt > mx:
  longest_str = current_str + my_str[ind+1]

print("--------------")
print(longest_str)
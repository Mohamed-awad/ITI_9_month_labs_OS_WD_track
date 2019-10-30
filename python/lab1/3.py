user_list = []

for i in range(5):
  user_list.append(input("enter array number : "))

print(user_list)
sorted_list = sorted(user_list)
print(sorted_list)
sorted_list.reverse()
print(sorted_list)
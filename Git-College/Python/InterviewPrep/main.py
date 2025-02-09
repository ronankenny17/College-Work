
# FizzBuzz
for i in range(100):
    if i % 3 ==0 and i % 5 ==0 :
        print("FizzBuzz")

    elif i %3 ==0 :
        print("fizz")

    elif i % 5 ==0 :
        print("Buzz")



    print("----")

tf = True
# palindrome check
word = input("enter work to be checked:")
i = 0
j = len(word)-1
while tf and i != j :
    if word[i] != word[j]:
        tf=False

    i+=1
    j-=1

if tf == False:
    print("not a palindrome")
else: print("palindrome!")
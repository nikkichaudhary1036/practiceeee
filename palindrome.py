# Check if a string is a palindrome
def is_palindrome(text):
    text = text.lower().replace(" ", "")  # make lowercase and remove spaces
    return text == text[::-1]

# Example usage
word = input("Enter a word or phrase: ")
if is_palindrome(word):
    print("✅ It's a palindrome!")
else:
    print("❌ Not a palindrome.")

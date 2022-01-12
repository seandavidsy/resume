
# Online Python - IDE, Editor, Compiler, Interpreter

def read_text(input_file):
    text = ""
    with open(input_file) as file:
        for line in file:
            text += str(line)
    return text
    
def clean_text(input_text):
    clean_text = input_text.lower()
    clean_text = ''.join(char for char in clean_text if char.isalnum() or char == " " or char == "\n")
    return clean_text
    
def get_word_frequencies(words):
    word_dict = dict()
    for word in words:
        if word not in word_dict:
            word_dict[word] = words.count(word)
    return word_dict
    
def count_all_syllables(words):
    count = 0
    for word in words:
        count += count_syllables(word)
    return count
    
def count_syllables(word):
    ''' Estimates and returns the number of syllables in
    the specified word. '''
    syllables = 0
    vowels = 'aeiouy'
    word = word.lower().strip(".:;?!")
    if word[0] in vowels:
        syllables += 1
    for index in range(1, len(word)):
        if word[index] in vowels and word[index-1] not in vowels:
            syllables += 1
    if word.endswith('e'):
        syllables -= 1
    if word.endswith('le'):
        syllables += 1
    if syllables == 0:
        syllables = 1
    return syllables
    
def main():
    print("Welcome to the Reading Ease Analyzer!")
    file = input("Name of file to analyze? ")
    
    raw = read_text(file)
    cleaned = clean_text(raw)
    words = cleaned.split()
    word_dict = get_word_frequencies(words)
    syllable_count = count_all_syllables(words)
    sentence_count = raw.count(".") + raw.count("!") + raw.count("?")
    avg_wps = (len(words) / sentence_count)
    avg_spw = (syllable_count) / len(words)
    reading_ease_score = round((206.835 - (1.015 * avg_wps) - (84.6 * avg_spw)), 1)
    grade_level = round(((0.39 * avg_wps) + (11.8 * avg_spw) - 15.59), 1)    

    print("Number of sentences:", sentence_count)
    print("Number of words:", len(words))
    print("Number of unique words:", len(word_dict))
    print("Average words per sentence:", round(avg_wps, 1))
    print("Average syllables per word:", round(avg_spw, 1))
    print("Reading-ease score:", reading_ease_score)
    print("U.S. grade level:", grade_level)
    
    
    word_check = ""
    while (word_check != "q"):
        word_check = input('Enter word to check ("q" to quit): ')
        word_check = word_check.lower()
        word_count = 0
        if word_check in word_dict:
            word_count = word_dict[word_check]
        print('The word "' + word_check + '" appears', word_count, "times.")
        
    print("\nThanks for using the Reading Ease Analyzer!")

if __name__ == "__main__":
    main()

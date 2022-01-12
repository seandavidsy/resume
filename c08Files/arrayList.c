// Declare any static helper functions here:
// On my honor:
//
// - I have not discussed the C language code in my program with
// anyone other than my instructor or the teaching assistants
// assigned to this course.
//
// - I have not used C language code obtained from another student,
// the Internet, or any other unauthorized source, either modified
// or unmodified.
//
// - If any C language code or documentation used in my program
// was obtained from an authorized source, such as a text book or
// course notes, that has been clearly noted with a proper citation
// in the comments of my program.
//
// - I have not designed this program in such a way as to defeat or
// interfere with the normal operation of the Curator System.
//
// Sean Sy
// seandwsy

#include "arrayList.h"
#include <stdlib.h>
#include <string.h>
#include <assert.h>

// Declare any static helper functions here:

arrayList* AL_create(uint32_t dimension, uint32_t elemSz, 
					int32_t (*compareElems)(const void* const pLeft, const void* const pRight),
					void (*cleanElem)(void* const pElem)) {

	arrayList *newArrayList = calloc(1, sizeof(arrayList));

	newArrayList->data = calloc(dimension, elemSz);
	newArrayList->elemSz = elemSz;
	newArrayList->capacity = dimension;
	newArrayList->usage = 0;
	newArrayList->compareElems = compareElems;
	newArrayList->cleanElem = cleanElem; 

	return newArrayList;
}

bool AL_insert(arrayList* const pAL, const void* const pElem) {
	
	if (pAL->usage >= pAL->capacity) {
		pAL->capacity *= 2;
		pAL->data = realloc(pAL->data, pAL->capacity * pAL->elemSz);
	}
   
	for (uint32_t i = 0; i <= pAL->capacity; i++) {
		void *elem = pAL->data + (i * pAL->elemSz);

		if (pAL->usage == i) { 
			memcpy(elem, pElem, pAL->elemSz);
			pAL->usage += 1;
			return true;
		}

		if (pAL->compareElems(pElem, elem) < 0) {
			uint32_t index = pAL->usage;
			while (index > i) {
				void *temp_elem1 = pAL->data + (index * pAL->elemSz);
				void *temp_elem2 = pAL->data + ((index - 1) * pAL->elemSz);
				memcpy(temp_elem1, temp_elem2, pAL->elemSz);
				index -= 1;
			}
      		memcpy(elem, pElem, pAL->elemSz);
			pAL->usage += 1;
			return true;
		}
	}
   
	return false;
}

void* AL_elemAt(const arrayList* const pAL, uint32_t index) {
	
	void *elem = NULL;
	if ((index < pAL->capacity) & (index < pAL->usage)) {
		elem = pAL->data + (index * pAL->elemSz);
	}

	return elem;
}

void* AL_find(const arrayList* const pAL, const void* const pElem) {

	for (uint32_t i = 0; i < pAL->capacity; i++) {
		void *elem = pAL->data + (i * pAL->elemSz);
		int32_t comparison = pAL->compareElems(elem, pElem);
		
		if (comparison == 0) {
			return elem;
		}
	}
	
	return NULL;
}

void AL_clean(arrayList* const pAL) {

	for (uint32_t i = 0; i < pAL->capacity; i++) {
		void *elem = pAL->data + (i * pAL->elemSz);
		pAL->cleanElem(elem);
	}
	free(pAL->data);	
	pAL->elemSz = 0;
	pAL->capacity = 0;
	pAL->usage = 0;
}
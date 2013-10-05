///////////////////////////////////////////////////////////
//  DisplayInterface.h
//  Implementation of the Class DisplayInterface
//  Created on:      05-Ê®ÔÂ-2013 11:16:07
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_A009F814_1773_446d_A907_5EC81ACAAFBA__INCLUDED_)
#define EA_A009F814_1773_446d_A907_5EC81ACAAFBA__INCLUDED_

class DisplayInterface
{

public:
	DisplayInterface();
	virtual ~DisplayInterface();

	char* GetDispBuf();
	void SetDispBuf(const char* dispBuf);
	virtual void UpdateDisplay() =0;

};
#endif // !defined(EA_A009F814_1773_446d_A907_5EC81ACAAFBA__INCLUDED_)

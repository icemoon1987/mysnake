///////////////////////////////////////////////////////////
//  DisplayModule.h
//  Implementation of the Class DisplayModule
//  Created on:      05-Ê®ÔÂ-2013 18:14:17
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_54394FEF_547B_4d9c_9B44_097D286EF3F6__INCLUDED_)
#define EA_54394FEF_547B_4d9c_9B44_097D286EF3F6__INCLUDED_

#include "DisplayInterface.h"

class DisplayModule : public DisplayInterface
{

public:
	DisplayModule();
	virtual ~DisplayModule();

	char* GetDispBuf();
	void SetDispBuf(const char* dispBuf);
	void UpdateDisplay();

private:
	char* m_dispBuf;
	int m_rowLen;

};
#endif // !defined(EA_54394FEF_547B_4d9c_9B44_097D286EF3F6__INCLUDED_)

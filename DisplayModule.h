///////////////////////////////////////////////////////////
//  DisplayModule.h
//  Implementation of the Class DisplayModule
//  Created on:      05-Ê®ÔÂ-2013 11:16:07
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_077AE6DA_71C4_4403_8019_ED389566B3DC__INCLUDED_)
#define EA_077AE6DA_71C4_4403_8019_ED389566B3DC__INCLUDED_

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
#endif // !defined(EA_077AE6DA_71C4_4403_8019_ED389566B3DC__INCLUDED_)

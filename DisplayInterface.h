///////////////////////////////////////////////////////////
//  DisplayInterface.h
//  Implementation of the Class DisplayInterface
//  Created on:      05-Ê®ÔÂ-2013 18:14:17
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_645C3FC6_7A3E_459e_9D34_BEC7F44D6F19__INCLUDED_)
#define EA_645C3FC6_7A3E_459e_9D34_BEC7F44D6F19__INCLUDED_

class DisplayInterface
{

public:
	DisplayInterface();
	virtual ~DisplayInterface();

	virtual char* GetDispBuf() =0;
	virtual void SetDispBuf(const char* dispBuf) =0;
	virtual void UpdateDisplay() =0;

};
#endif // !defined(EA_645C3FC6_7A3E_459e_9D34_BEC7F44D6F19__INCLUDED_)

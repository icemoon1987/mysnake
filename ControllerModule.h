///////////////////////////////////////////////////////////
//  ControllerModule.h
//  Implementation of the Class ControllerModule
//  Created on:      05-Ê®ÔÂ-2013 18:14:17
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_2ED72515_7BA7_4d5d_A9A0_4E231DF28255__INCLUDED_)
#define EA_2ED72515_7BA7_4d5d_A9A0_4E231DF28255__INCLUDED_

#include "ControlInterface.h"

class ControllerModule : public ControlInterface
{

public:
	ControllerModule();
	virtual ~ControllerModule();

	int GetKey();

};
#endif // !defined(EA_2ED72515_7BA7_4d5d_A9A0_4E231DF28255__INCLUDED_)

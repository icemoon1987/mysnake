///////////////////////////////////////////////////////////
//  ControlInterface.h
//  Implementation of the Class ControlInterface
//  Created on:      05-Ê®ÔÂ-2013 18:14:17
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_08EC2450_C64F_4a4e_A6A9_94A046AC05D4__INCLUDED_)
#define EA_08EC2450_C64F_4a4e_A6A9_94A046AC05D4__INCLUDED_

class ControlInterface
{

public:
	ControlInterface();
	virtual ~ControlInterface();

	virtual int GetKey() =0;

};
#endif // !defined(EA_08EC2450_C64F_4a4e_A6A9_94A046AC05D4__INCLUDED_)

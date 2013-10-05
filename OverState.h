///////////////////////////////////////////////////////////
//  OverState.h
//  Implementation of the Class OverState
//  Created on:      05-Ê®ÔÂ-2013 11:16:08
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_5B0B5801_DEC0_4acd_B7C2_67461F60C7B2__INCLUDED_)
#define EA_5B0B5801_DEC0_4acd_B7C2_67461F60C7B2__INCLUDED_

#include "SnakeState.h"

class OverState : public SnakeState
{

public:
	OverState();
	virtual ~OverState();

	void ProcessCmd(const int cmd);

private:
	SnakeCore& m_snake;

};
#endif // !defined(EA_5B0B5801_DEC0_4acd_B7C2_67461F60C7B2__INCLUDED_)

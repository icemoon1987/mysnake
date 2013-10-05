///////////////////////////////////////////////////////////
//  OverState.h
//  Implementation of the Class OverState
//  Created on:      05-Ê®ÔÂ-2013 18:14:18
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_A54C8819_D0BD_46ca_A7DB_2A135867C269__INCLUDED_)
#define EA_A54C8819_D0BD_46ca_A7DB_2A135867C269__INCLUDED_

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
#endif // !defined(EA_A54C8819_D0BD_46ca_A7DB_2A135867C269__INCLUDED_)

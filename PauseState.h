///////////////////////////////////////////////////////////
//  PauseState.h
//  Implementation of the Class PauseState
//  Created on:      05-Ê®ÔÂ-2013 18:14:18
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_54E508C6_99D0_4ef0_950A_DAB868268692__INCLUDED_)
#define EA_54E508C6_99D0_4ef0_950A_DAB868268692__INCLUDED_

#include "SnakeState.h"

class PauseState : public SnakeState
{

public:
	PauseState();
	virtual ~PauseState();

	void ProcessCmd(const int cmd);

private:
	SnakeCore& m_snake;

};
#endif // !defined(EA_54E508C6_99D0_4ef0_950A_DAB868268692__INCLUDED_)

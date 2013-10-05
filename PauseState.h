///////////////////////////////////////////////////////////
//  PauseState.h
//  Implementation of the Class PauseState
//  Created on:      05-Ê®ÔÂ-2013 11:16:08
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_200EB114_CC89_4c2c_BD3D_6D25A282A6F0__INCLUDED_)
#define EA_200EB114_CC89_4c2c_BD3D_6D25A282A6F0__INCLUDED_

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
#endif // !defined(EA_200EB114_CC89_4c2c_BD3D_6D25A282A6F0__INCLUDED_)

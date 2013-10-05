///////////////////////////////////////////////////////////
//  PlayState.h
//  Implementation of the Class PlayState
//  Created on:      05-Ê®ÔÂ-2013 18:14:18
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_3210C2DA_A61A_49ed_9456_93797D5DC138__INCLUDED_)
#define EA_3210C2DA_A61A_49ed_9456_93797D5DC138__INCLUDED_

#include "SnakeState.h"

/**
 * a state for normal playing
 */
class PlayState : public SnakeState
{

public:
	PlayState();
	virtual ~PlayState();

	void ProcessCmd(const int cmd);

private:
	SnakeCore& m_snake;

};
#endif // !defined(EA_3210C2DA_A61A_49ed_9456_93797D5DC138__INCLUDED_)

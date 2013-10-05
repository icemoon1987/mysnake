///////////////////////////////////////////////////////////
//  PlayState.h
//  Implementation of the Class PlayState
//  Created on:      05-Ê®ÔÂ-2013 11:16:08
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_858264BF_A686_4329_B9A2_89CF0D15DC70__INCLUDED_)
#define EA_858264BF_A686_4329_B9A2_89CF0D15DC70__INCLUDED_

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
#endif // !defined(EA_858264BF_A686_4329_B9A2_89CF0D15DC70__INCLUDED_)

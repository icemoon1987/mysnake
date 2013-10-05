///////////////////////////////////////////////////////////
//  SnakeControlAdapter.h
//  Implementation of the Class SnakeControlAdapter
//  Created on:      05-Ê®ÔÂ-2013 18:14:18
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_568F4888_2EC6_4a50_A052_590631DEC8B9__INCLUDED_)
#define EA_568F4888_2EC6_4a50_A052_590631DEC8B9__INCLUDED_

#include "ControlInterface.h"

/**
 * Change the keyboard input into command
 */
class SnakeControlAdapter
{

public:
	SnakeControlAdapter();
	virtual ~SnakeControlAdapter();
	ControlInterface *m_ControlInterface;

	int GetCommand();

private:
	/**
	 * a reference of ControlInterface
	 */
	ControlInterface& m_ctrlIf;

};
#endif // !defined(EA_568F4888_2EC6_4a50_A052_590631DEC8B9__INCLUDED_)

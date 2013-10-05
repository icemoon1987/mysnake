///////////////////////////////////////////////////////////
//  SnakeControlAdapter.h
//  Implementation of the Class SnakeControlAdapter
//  Created on:      05-Ê®ÔÂ-2013 11:16:08
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_E075C4F7_E6B8_42b9_B802_B1162C59F339__INCLUDED_)
#define EA_E075C4F7_E6B8_42b9_B802_B1162C59F339__INCLUDED_

#include "SnakeCmd.h"
#include "ControlInterface.h"

/**
 * Change the keyboard input into command
 */
class SnakeControlAdapter
{

public:
	SnakeControlAdapter();
	virtual ~SnakeControlAdapter();
	SnakeCmd *m_SnakeCmd;
	ControlInterface *m_ControlInterface;

	int GetCommand();

private:
	/**
	 * a reference of ControlInterface
	 */
	ControlInterface& m_ctrlIf;

};
#endif // !defined(EA_E075C4F7_E6B8_42b9_B802_B1162C59F339__INCLUDED_)
